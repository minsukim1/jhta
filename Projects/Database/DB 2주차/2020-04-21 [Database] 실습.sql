-- 셀프조인(자체조인)
-- 101번 사원의 이름, 직종, 자신의 상사이름을 조회하기
select EMP.first_name 직원명, EMP.job_id "직원의 직종", MGR.first_name "상사의 이름"
from employees EMP, employees MGR
where EMP.employee_id = 101
and EMP.manager_id = MGR.employee_id;
-- 60번 부서에 근무중인 직원의 아이디 이름, 직원의 직종, 상사의 이름, 상사의 직종,
-- 직원의 소속 부서아이디, 직원의 소속 부서명, 부서관리자 아이디, 부서관리자 이름을 조회하기
select 직원.employee_id 직원의아이디, 직원.first_name 직원이름, 직원.job_id "직원의 직종",
        상사.first_name "상사의 이름", 상사.job_id "상사의 직종",
        부서.department_id "직원 부서 아이디", 부서.department_name "직원 소속 부서명", 부서.manager_id "부서관리자 아이디",
        부서관리자.first_name "부서관리자 이름"
from employees 직원, employees 상사, departments 부서, employees 부서관리자
where 직원.department_id = 60
and 직원.manager_id = 상사.employee_id -- 직원과 상사 간의 조인조건
and 직원.department_id = 부서.department_id -- 직원과 소속 부서 간의 조인조건
and 부서.manager_id = 부서관리자.employee_id; -- 부서와 부서관리자 간의 조인조건
-- 포괄조인
-- 부서아이디, 부서명, 부서관리자 아이디, 부서관리자 이름 조회하기
select A.department_id, A.department_name, A.manager_id, B.first_name
from departments A, employees B
where A.manager_id = B.employee_id(+)
order by department_id;
-- 모든 직원의 이름, 급여 ,직종아이디, 소속부서명을 조회하기
select *
from employees A, departments B
where A.department_id = B.department_id(+)
order by A.employee_id;
-- 다중행 함수 사용하기
-- employees의 모든 행의 개수 조회하기
select count(*)
from employees;
-- 50번 부서에서 일하는 직원의 수를 조회하기
select count(*)
from employees
where department_id = 50;
-- 커미션을 받는 직원의 수를 조회하기
select count(commission_pct)    -- 컬럼을 지정하면 해당 컬럼의 값이 null이 아닌 것만 카운트 한다.
from employees;
-- 커미션을 받는 직원의 수를 조회하기
select count(*)
from employees
where commission_pct is not null;
-- 직원들 중에서 최고급여, 최저급여를 받는 직원의 급여를 조회하기
select max(salary), min(salary)
from employees;
-- 최고급여를 받는 사람의 이름과 최고급여를 조회하기
select first_name, max(salary) -- 오류 : 그룹함수와 그룹함수가 아닌 표현식을 같이 조회할 수 없다.
from employees;
-- 조회된 행의 개수를 구하기
-- count(*) : 조회된 모든 행의 개수를 반환한다.
-- count(컬럼명) : 해당 컬럼의 값이 null 이 아닌 행의 개수를 반환한다.
-- count(distinct 컬럼명) : 해당 컬럼의 값에 대해 중복된 값은 1번만 카운트해서 행의 개수를 반환한다.
select count(*)
from employees;             -- 107
select count(job_id)
from employees;             -- 107
select count(distinct job_id)
from employees;             -- 19, 총 19개의 직종에 근무하고 있음
select count(distinct to_char(hire_date, 'yyyy'))
from employees;
-- 조회된 행의 특정 컬럼에 대한 합계를 구하기
-- sum(컬럼명) : 해당 컬럼의 값 중에서 null을 제외한 값들의 합계를 반환한다.
select sum(salary) -- 전체 사원들의 급여 총액
from employees;
select sum(commission_pct) -- 전체 사원들의 커미션에 대한 합계
from employees;            -- 커미션의 값이 null인 것은 계산에 포함되지 않음
-- 조회된 행의 특정 컬럼에 대한 평균을 구하기
-- avg(컬럼명) : 해당 컬럼의 값 중에서 null을 제외한 값을 가진 행들에 대한 평균값을 반환한다.
select trunc(avg(salary)) -- 전체 직원들의 급여 평균
from employees;
select trunc (avg(commission_pct), 2)
from employees;
-- 조회된 행의 특정 컬럼에 대한 최대값, 최소값 구하기
-- min(컬럼명) : 해당 컬럼의 값 중에서 null을 제외한 가장 작은 값을 반환한다.
-- max(컬럼명) : 해당 컬럼의 값 중에서 null을 제외한 가장 큰 값을 반환한다.
select min(salary), max(salary)
from employees;
select min(commission_pct), max(commission_pct)
from employees;
-- group by와 그룹함수를 사용해서 데이터 집계하기
-- 직종별 직원수를 조회하기
select job_id, count(*)
from employees
group by job_id;
-- 입사년도별 사원수
select to_char(hire_date, 'yyyy'), count(*)
from employees
group by to_char(hire_date, 'yyyy')
order by 1;