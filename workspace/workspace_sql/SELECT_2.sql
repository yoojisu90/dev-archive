#복습
SELECT * FROM emp;

#1. EMP 테이블에 저장된 사원 중 부서번호가 30인 사원의 사번, 이름, 부서번호 조회
SELECT EMPNO,ENAME,DEPTNO
FROM emp
WHERE DEPTNO = 30;

#2. EMP 테이블에서 직급이 대리가 아니거나, 급여가 600 이하인 사원들의
#   사번, 사원명, 직급, 급여를 조회
SELECT EMPNO,ENAME,JOB,SAL
FROM emp
WHERE JOB != '대리'
OR SAL <= 600; 

#3. 직급이 대리 또는 사원이면서 급여는 400을 초과하는
#   직원들의 모든 컬럼 정보 조회
SELECT *
FROM emp
WHERE (JOB = '대리' OR JOB = '사원')
AND SAL > 400;


#4. 급여가 800이하인 직원 중에서 커미션이 NULL이 아닌 직원의 모든 컬럼 조회
SELECT *
FROM emp
WHERE SAL <= 800
AND COMM IS NOT NULL;

#-----------------------------------------------------------------------

#별칭을 사용한 조회
#조회 시 컬럼명 뒤에 AS키워드를 붙이고, 별칭을 작성하면 조회 시 별칭이 적용된다
#별칭을 부여할 때는 AS 키워드는 생략 가능하다.
SELECT EMPNO AS NO, ENAME AS 이름, SAL 급여
FROM emp;

SELECT EMPNO ENAME
FROM emp;

# EMP 테이블에서 급여가 300이상이고, 600이하인 사원들의 사번, 사원명, 급여를 조회
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE 300<=SAL AND SAL<=600;

#위 조건은 BETWEEN A AND B 연산자를 이용하기도 함
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL BETWEEN 300 AND 600;

# EMP 테이블에서 급여가 400이거나 500이거나 600인 사원들의 모든 컬럼 정보 조회
SELECT *
FROM emp
WHERE SAL=400 OR SAL=500 OR SAL=600;

SELECT *
FROM emp
WHERE SAL IN(400,500,600);

#데이터 정렬
# ORDER BY 정렬할 컬럼명 정렬방식;
# 정렬방식 : 오름차순(ASC, 생략가능) , 내림차순(DESC)

#모든 사원의 모든 컬럼 정보를 조회하되, 급여기준 내림차순 정렬
SELECT * FROM emp ORDER BY SAL DESC;

#부서 번호 기준 오름차순 정렬
SELECT * FROM emp ORDER BY DEPTNO ASC;
SELECT * FROM emp ORDER BY DEPTNO;

#직급이 사장인 사원을 제외한 모든 사원의 모든 컬럼 정보를 조회,
#단 직급 기준 내림차순으로 정렬
SELECT * FROM emp WHERE JOB != '사장' ORDER BY JOB DESC;

#모든 컬럼을 조회하되, 직급기준 오름차순 정렬 후 직급이 동일하면 
#급여기준 내림차순 정렬
SELECT * FROM emp ORDER BY JOB ASC, SAL DESC;

#LIE 연산자와 와일드카드
#와일드 카드 : %,_
# % : 글자 수 제한없는 어떤 글자
# _ : 한 글자로 이루어진 어떤 글자

#이름에 '이'라는 글자가 포함된 사원들의 모든 컬럼 정보 조회
SELECT * FROM emp WHERE ENAME LIKE '%이%';

#-----------------------------------------------------------------
#실습

#1. EMP 테이블에서 모든 사원의 사번, 사원명, 급여, 커미션을 조회하시오.
SELECT EMPNO,ENAME,SAL,COMM
FROM emp;
#2. EMP 테이블에서 사번이 1005번 이상인 사원들의 사번, 사원명, 직급을 조회하되, 사원명은 ‘NAME’이라는 별칭으로 조회하시오.
SELECT EMPNO,ENAME NAME,JOB
FROM emp
WHERE EMPNO >= 1005;
#3. EMP 테이블에서 직급이 대리이거나과장인 사원들의 사원명, 직급, 급여를 조회하시오.
SELECT ENAME,JOB,SAL
FROM emp
WHERE JOB ='대리' OR JOB='과장';
#4. EMP 테이블에서 급여가 300 이상이면서 커미션이 300 이상인 사원들의 모든 컬럼을 조회하시오.
SELECT * FROM emp
WHERE SAL >=300 AND COMM >=300;
#5. EMP 테이블에서 급여가 900 이하이고 커미션은 NULL이 아니며 직급은 대리이거나 과장인 사원들의 사원명, 직급, 급여, 커미션을 조회하시오.
SELECT ENAME,JOB,SAL,COMM
FROM emp
WHERE SAL<=900 AND COMM IS NOT NULL
AND (JOB ='대리' OR JOB ='과장');

#1. EMP 테이블에서 커미션이 NULL이 아닌 사원 중, 급여가 350에서 650 사이인 사원들의 사원명, 급여, 커미션을 조회하되, 쿼리문 작성 시 BETWEEN
#연산자를 사용하여 작성하시오.
SELECT ENAME,SAL,COMM FROM emp
WHERE COMM IS NOT NULL AND SAL BETWEEN 350 AND 650;
#2. 직급이 과장, 차장, 부장인 직원의 사번, 사원명, 직급을 조회하되, 직급 기준 오름차순으로 정렬하고, 쿼리 작성 시 IN 연산자를 사용하시오.
SELECT EMPNO,ENAME,JOB FROM emp
WHERE JOB IN('과장','차장','부장')
ORDER BY JOB ASC;
#3. 부서번호가 10, 20인 부서에 소속된 직원 중, 이름에 ‘이’가 포함된 직원의 사번, 사원명, 부서번호, 급여를 조회하되, 부서번호 기준 내림차순으로 정렬 후,
#부서번호가 같다면 급여가 낮은 순부터 조회하는 쿼리문을 작성하시오.
SELECT EMPNO,ENAME,DEPTNO,SAL FROM emp
WHERE DEPTNO IN(10,20) AND ENAME LIKE '%이%'
ORDER BY DEPTNO DESC, SAL ASC;

#4. 이름이 ‘기＇로 끝나는 직원 중, 커미션은 NULL이고 급여는 400에서 800 사이인 직원의 모든 컬럼 정보를 조회하시오.
SELECT * FROM emp
WHERE ENAME LIKE '%기' AND COMM IS NULL AND SAL BETWEEN 400 AND 800;

