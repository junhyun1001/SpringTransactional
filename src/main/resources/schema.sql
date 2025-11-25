-- 1. 상품 테이블 (Product)
CREATE TABLE product
(
    id    BIGINT AUTO_INCREMENT PRIMARY KEY, -- 상품 ID
    name  VARCHAR(100) NOT NULL,             -- 상품명
    price INT          NOT NULL,             -- 가격
    stock INT          NOT NULL              -- 재고 수량 (핵심!)
);

-- 2. 주문 테이블 (Orders)
-- 'ORDER'는 SQL 예약어라 보통 'ORDERS'로 만듭니다.
CREATE TABLE orders
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY, -- 주문 ID
    product_id BIGINT NOT NULL,                   -- 주문한 상품 ID
    quantity   INT    NOT NULL,                   -- 주문 수량
    created_at DATETIME DEFAULT NOW()             -- 주문 시간
);