-- Create services table
CREATE TABLE IF NOT EXISTS services (
    id integer PRIMARY KEY,
    txn_ref VARCHAR(100) UNIQUE NOT NULL,
    amount BIGINT NOT NULL,
    description TEXT NOT NULL,
    duration VARCHAR(100) NOT NULL
);

-- Insert sample service packages
INSERT INTO services (id, txn_ref, amount, description, duration)
VALUES 
    (1, 'BASIC_STORAGE', 99000, 'Gói Cơ Bản', '1 tháng'),
    (2, 'STANDARD_STORAGE', 299000, 'Gói Tiêu Chuẩn', '3 tháng'),
    (3, 'PREMIUM_STORAGE', 599000, 'Gói Cao Cấp', '6 tháng'),
    (4, 'ULTIMATE_STORAGE', 999000, 'Gói Tối Ưu', '12 tháng');
