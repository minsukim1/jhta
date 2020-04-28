-- 책에 대한 리뷰와 평점을 담는 테이블
create table sample_book_reviews (
    review_no number(7,0)         constraint review_no_pk PRIMARY KEY,
    review_content varchar2(2000) constraint review_content_nn NOT NULL,
    review_point number(1,0)      constraint review_point_ck CHECK (review_point >=0 and review_point <=5),
    review_registered_date date   default sysdate,
    book_no number(7,0)           constraint review_bookno_fk references sample_books (book_no),
    user_id varchar2(50)          constraint review_userid_fk references sample_book_users (user_id),
    constraint reviews_uk UNIQUE (book_no, user_id)
);

create sequence sample_review_seq NOCACHE;

insert into sample_book_reviews
(review_no, review_content, review_point, book_no, user_id)
values
(sample_review_seq.nextval, '아주 좋은 내용이었습니다.', 5, 10006, 'hong');

insert into sample_book_reviews
(review_no, review_content, review_point, book_no, user_id)
values
(sample_review_seq.nextval, '잘 읽었습니다.', 5, 10005, 'hong5678');

insert into sample_book_reviews
(review_no, review_content, review_point, book_no, user_id)
values
(sample_review_seq.nextval, '잘 읽었습니다.', 5, 10005, 'hong');

COMMIT;

create table sample_book_likes (
    book_no number(7,0) not null,
    user_id varchar2(50) not null,
    constraint likes_bookno_fk FOREIGN KEY (book_no) references sample_books (book_no),
    constraint likes_userid_fk FOREIGN KEY (user_id) references sample_book_users (user_id),
    constraint likes_uk UNIQUE (book_no, user_id)
);



-- 사원아이디, 이름, 급여, 급여등급을 포함하고있는 가상의 테이블
create or replace view emp_salary_grade_view
as select A.employee_id, A.first_name, A.salary, B.gra
   from employees A, job_grades B
   where A.salary >= B.lowest_sal and A.salary <= B.highest_sal;
   
   select *
   from emp_salary_grade_view
   where gra = 'A';
   
-- 인라인뷰 사용하기
select id, name, salary, deptid
from (select employee_id id, first_name || ' ' || last_name name, salary, department_id deptid
      from employees)
where deptid = 60;

-- 전체 직원 중에서 자신이 소속된 부서의 평균급여보다 급여를 적게 받는 사원의
-- 사원 아이디, 이름, 급여, 부서아이디, 부서의 평균급여를 조회하기
select A.employee_id, A.first_name, A.salary, A.department_id, B.avg_salary
from employees A,(select department_id deptid, trunc(avg(salary)) as avg_salary
                  from employees
                  where department_id is not null
                  group by department_id) B
where B.deptid = A.department_id
and A.salary <= B.avg_salary
order by A.employee_id asc;

-- 부서아이디, 부서명, 부서별 사원수, 도시명을 출력하기
select A.department_id, A.department_name, C.cnt, B.city
from departments A, locations B, (select department_id dept_id, count(*) cnt
                                  from employees
                                  group by department_id) C
where A.location_id = B.location_id
and A.department_id = C.dept_id
order by A.department_id asc;
create sequence sample_question_seq start with 1000000 nocache;
create sequence sample_answer_seq start with 1000000 nocache;