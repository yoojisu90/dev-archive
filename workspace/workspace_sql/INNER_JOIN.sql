# 조인(JOIN)

# --사전 지식 --
# 사원번호, 사원명, 급여, 부서번호를 조회
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp;

#위 쿼리문에 생략된 부분을 살리면...
SELECT EMP.EMPNO, EMP.ENAME, EMP.SAL, EMP.DEPTNO
FROM emp;

#별칭을 테이블명에 적용시키면...
SELECT EMPNO, ENAME, SAL 급여, DEPTNO AS 부서번호
FROM emp 부서정보;

#위 두 내용을 함꼐 사용하면 다음과 같다.
SELECT E.EMPNO, E.ENAME, E.SAL, E.DEPTNO
FROM emp E;

# --- 조인의 기본문법(Cross Join) ---
#사번, 사원명, 급여, 부서명을 조회
SELECT * FROM emp; #14
SELECT * FROM dept; #4

SELECT EMPNO, ENAME, SAL, DNAME, EMP.DEPTNO, dept.DEPTNO
FROM emp INNER JOIN dept
ON emp.DEPTNO = dept.DEPTNO; # Inner Join (조건을 통해서 조회)

#급여가 300이상인 사원들의 사번, 사원명, 급여, 부서번호, 부서명, 부서지역을
#조회하되, 급여 기준 내림차순으로 정렬
SELECT EMPNO, ENAME, SAL, E.DEPTNO, DNAME, LOC
FROM emp E INNER JOIN dept D
ON E.EMPNO = D.DEPTNO
WHERE SAL >= 300
ORDER BY SAL DESC;