-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, HIRE_YMD
from doctor
where MCDP_CD='cs' or MCDP_CD='gs'
order by hire_ymd desc, dr_name asc;