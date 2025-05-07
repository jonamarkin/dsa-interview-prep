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