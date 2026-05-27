-- 코드를 입력하세요
SELECT member_id, member_name, gender, 
    TO_CHAR(date_of_birth, 'YYYY-MM-DD')AS date_of_birth
FROM MEMBER_PROFILE 
WHERE TO_CHAR(date_of_birth, 'MM')='03'
    AND GENDER='W'
    AND TLNO IS NOT NULL
ORDER BY MEMBER_ID ASC;