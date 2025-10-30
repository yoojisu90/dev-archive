
# 단일행 함수
# 함수 사용으로 인해 조회되는 행의 갯수가 한개만 존재하는 함수를 단일행 함수

#단일행 함수가 아닌 함수의 예시
SELECT SUBSTR(ENAME, 2, 1), ENAME FROM emp;

#단일행 함수의 예시
SELECT MAX(SAL) FROM emp;

#단일행 함수의 종류
SELECT MAX(SAL), MIN(SAL), SUM(SAL), COUNT(SAL), AVG(SAL) FROM emp;

#COUNT 단일행 함수 사용 시 주의사항
#COUNT 함수는 조회되는 데이터의 수를 파악 할 때 사용
#단, NULL 데이터는 갯수에 포함하지 않는다.
# ex> EMP 테이블에 저장된 데이터의 갯수를 조회
# 첫번째 방식(*를 활용)
SELECT COUNT(*) FROM emp;
# 두번째 방식(PK를 활용)
SELECT COUNT(EMPNO) FROM emp;

SELECT COUNT(SAL), COUNT(EMPNO), COUNT(ENAME), COUNT(COMM) FROM emp;

#단일행 함수 사용 시 주의사항
#조회하려는 모든 컬럼의 조회 갯수가 동일해야 쿼리가 정상 작동 됨.
SELECT EMPNO, ENAME, SUM(SAL) FROM emp;

#GROUP BY절 : 특정 컬럼 기준으로 통계 데이터를 볼 수 있음
#모든 직원의 급여의 합
SELECT SUM(SAL) FROM emp;

#직급별 직원 급여의 합
SELECT JOB, SUM(SAL) FROM emp
GROUP BY JOB;

#부서별 급여의 평균값, 최대값, 최소값
SELECT AVG(SAL), MAX(SAL), MIN(SAL), DEPTNO, 
	(SELECT DNAME
	FROM dept
	WHERE DEPTNO = emp.DEPTNO) AS 부서명
FROM emp
GROUP BY DEPTNO;

#부서별 사원수를 조회. 단, 부서번호가 10번인 부서는 제외.
SELECT DEPTNO, COUNT(EMPNO)
FROM emp
WHERE DEPTNO != 10
GROUP BY DEPTNO;

#부서별 사원수를 조회. 단, 부서별 인원수가 5명 이하인 부서는 제외.
#GROUPING이 완료된 후 추가되는 조건은 HAVING절에 작성해야 한다.
SELECT DEPTNO, COUNT(EMPNO)
FROM emp
GROUP BY DEPTNO
HAVING COUNT(EMPNO) >= 5;

#직급별로 직급, 직급별 급여의 합을 조회
#직급이 사원과 사장인 직급은 제외하고, 직급별 급여의 합이 500 이상인 데이터만 조회
#또한, 조회되는 데이터는 직급별 급여의 합 기준 내림차순으로 정렬
SELECT JOB, SUM(SAL)
FROM emp
WHERE JOB NOT IN ('사원','사장')
GROUP BY JOB
HAVING SUM(SAL) >= 500
ORDER BY SUM(SAL) DESC;










