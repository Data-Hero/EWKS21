CREATE TABLE IF NOT EXISTS  FUNCTION_BUNDLE (
  id INT AUTO_INCREMENT PRIMARY KEY,
  functionBundleId VARCHAR(250) NOT NULL,
  functionId VARCHAR(250) NOT NULL,
  priceByMinute DOUBLE NOT NULL,
  discount DOUBLE
);
