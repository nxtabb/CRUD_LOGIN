package com.hrbeu.Entity;

public class Emp {
    private String EMPID;
    private String DEPTNO;
    private String EMPNAME;
    private int AGE;
    private String ADDRESS;
    private int SAL;

    public String getEMPID() {
        return EMPID;
    }

    public void setEMPID(String EMPID) {
        this.EMPID = EMPID;
    }

    public String getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(String DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    public String getEMPNAME() {
        return EMPNAME;
    }

    public void setEMPNAME(String EMPNAME) {
        this.EMPNAME = EMPNAME;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public int getSAL() {
        return SAL;
    }

    public void setSAL(int SAL) {
        this.SAL = SAL;
    }
    public Emp(){}
    public Emp(String EMPID, String DEPTNO, String EMPNAME, int AGE, String ADDRESS, int SAL) {
        this.EMPID = EMPID;
        this.DEPTNO = DEPTNO;
        this.EMPNAME = EMPNAME;
        this.AGE = AGE;
        this.ADDRESS = ADDRESS;
        this.SAL = SAL;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "EMPID='" + EMPID + '\'' +
                ", DEPTNO='" + DEPTNO + '\'' +
                ", EMPNAME='" + EMPNAME + '\'' +
                ", AGE=" + AGE +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", SAL=" + SAL +
                '}';
    }
}
