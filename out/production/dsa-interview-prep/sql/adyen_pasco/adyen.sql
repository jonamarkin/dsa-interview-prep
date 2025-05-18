-- At Adyen, we process countless transactions from various merchants every day.
-- We're interested in knowing the total revenue we generate from each merchant on a monthly basis.
-- We have a transactions table that stores all the transaction information -
-- this includes the merchant_id, transaction_date, and amount.
-- The amount is the total transaction value that is processed through us.
--
-- Write a SQL query using window functions to calculate the total revenue generated
-- per merchant per month.

SELECT
    EXTRACT(MONTH FROM transaction_date) AS MTH,
    EXTRACT(YEAR FROM transaction_date) AS year,
    merchant_id,
    SUM(amount) OVER (PARTITION BY MERCHANT_ID, EXTRACT(MONTH FROM TRANSACTION_DATE), EXTRACT(YEAR FROM TRANSACTION_dATE)) AS TOTAL_REVENUE
FROM transactions;

SELECT
    merchant_id,
    DATE_TRUNC('month', transaction_Date) AS month,
    SUM(amount) OVER (PARTITION BY merchant_id, DATE_TRUNC('month', transaction_date)) AS monthly_revenue
FROM transactions;

SELECT
    merchant_id,
    DATE_TRUNC('month', transaction_date) AS month,
    SUM(amount) AS monthly_revenue
FROM transactions
GROUP BY merchant_id, DATE_TRUNC('month', transaction_Date);


/*
    As a part of your role in Adyen, a global payment company, you are required to find out the average transaction
    amount per merchant in the previous quarter to spot the highest earning merchants and sustain business relations.
    Build a SQL query to solve this problem.

    Please find below the sample data:

    merchant_transactions Example Input:
    transaction_id	merchant_id	transaction_date	transaction_amount
    1001	501	04/10/2022 00:00:00	100.50
    1002	502	04/15/2022 00:00:00	350.00
    1003	501	05/01/2022 00:00:00	80.00
    1004	503	05/25/2022 00:00:00	550.00
    1005	502	06/15/2022 00:00:00	450.00
 */
SELECT
    merchant_id,
    AVG(transaction_amount) AS average_transaction_amount
FROM
    merchant_transactions
WHERE
    transaction_date >= DATE_TRUNC('quarter', CURRENT_DATE) - INTERVAL '3 months'
    AND transaction_date < DATE_TRUNC('quarter', CURRENT_DATE)
GROUP BY
    merchant_id
ORDER BY
    average_transaction_amount DESC;


/*
    As an assistant in Adyen, a global payment company, you are tasked to generate a report which shows the average daily
    volume of transactions for each merchant, over a certain month. The volume of a transaction is based on its amount.

    The transactions table contains the following columns:

    transaction_id (integer)
    date (Date)
    merchant_id (integer)
    amount (float) - The amount of money processed in the transaction.
    Generate a query that will output each merchant's ID, the month, and their respective average daily transaction volume for that month.

    transactions Example Input:
    transaction_id	date	merchant_id	amount
    101	2022-08-01	1	50000
    102	2022-08-02	1	70000
    103	2022-08-01	2	80000
    104	2022-08-03	1	55000
    105	2022-08-03	2	89000
    106	2022-08-02	2	65000
    Example Output:
    month	merchant_id	avg_daily_volume
    8	1	58333.33
    8	2	78000.00

 */
SELECT
    EXTRACT(MONTH FROM date) AS month,
    merchant_id,
    AVG(amount) AS avg_daily_volume
FROM
    transactions
WHERE
    date >= DATE_TRUNC('month', CURRENT_DATE) - INTERVAL '1 month'
    AND date < DATE_TRUNC('month', CURRENT_DATE)
GROUP BY
    EXTRACT(MONTH FROM date),
    merchant_id
ORDER BY
    month,
    merchant_id;


SELECT
    merchant_id,
    DATE_TRUNC('month', date) AS month,
    SUM(amount) / COUNT(DISTINCT date) AS avg_daily_volume
FROM transactions
GROUP BY merchant_id, DATE_TRUNC('month', date)
ORDER BY merchant_id, month;


/*
    As an Adyen analyst, you are provided with a database of customer records.
    Your task is to find all customers that have a billing address in "Netherlands".
    Keep in mind that the column storing their address is in the format Street, City, Country.

    Sample Input: 'customers'
    customer_id	first_name	last_name	billing_address
    001	John	Doe	123 Anywhere St, Amsterdam, Netherlands
    002	Jane	Smith	456 Another Rd, New York, USA
    003	Sam	Lee	789 Somewhere Ave, Rotterdam, Netherlands
    004	Mike	Taylor	321 Everywhere Blvd, London, UK
    005	Emma	Brown	654 Nowhere Ln, Utrecht, Netherlands
    Sample Output:
    customer_id	first_name	last_name	billing_address
    001	John	Doe	123 Anywhere St, Amsterdam, Netherlands
    003	Sam	Lee	789 Somewhere Ave, Rotterdam, Netherlands
    005	Emma	Brown	654 Nowhere Ln, Utrecht, Netherlands

 */
SELECT
    customer_id,
    first_name,
    last_name,
    billing_address
FROM
    customers
WHERE
    billing_address LIKE '%Netherlands%'
ORDER BY
    customer_id;


/*
    Adyen is a payments company that processes transactions for businesses.
    Given two tables - transactions and customer, you are asked to write a SQL query that returns each customer's name,
    total number of transactions and total amount spent. Assume each customer can have multiple transactions but
    each transaction can be associated with only one customer.

    Consider the following tables:

    transactions Example Input:
    transaction_id	customer_id	amount	transaction_date
    1001	501	150	01/20/2022
    1002	502	200	02/15/2022
    1003	501	100	01/21/2022
    1004	503	250	02/10/2022
    1005	501	75	01/20/2022
    customer Example Input:
    customer_id	name
    501	John
    502	Sara
    503	Daniel
    504	Monica

 */
SELECT
    c.customer_id,
    c.name,
    COUNT(t.transaction_id) AS total_transactions,
    SUM(t.amount) AS total_amount_spent
FROM
    customer c
JOIN
    transactions t ON c.customer_id = t.customer_id
GROUP BY
    c.customer_id,
    c.name
ORDER BY
    c.customer_id;