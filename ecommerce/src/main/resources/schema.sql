CREATE TABLE IF NOT EXISTS MEMBER (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    MEMBER_EMAIL VARCHAR(255) UNIQUE NOT NULL,
    MEMBER_PASSWORD VARCHAR(255) NOT NULL,
    MEMBER_NAME VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS PRODUCT (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 제품 ID (기본 키)
    MEMBER_ID VARCHAR(255) NOT NULL,  -- 회원 ID (외래 키로 사용할 수 있음)
    PRODUCT_NAME VARCHAR(255) NOT NULL,  -- 제품명
    PRICE INT NOT NULL,  -- 가격
    COUNT INT NOT NULL  -- 제품 수량
);