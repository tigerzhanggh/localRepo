package com.example.demo.testjdk17;


    /**
     *
     * @param stuId     学生ID
     * @param stuName   学生名称
     * @param stuAge    学生年龄
     * @param stuGender 学生性别
     * @param stuEmail  学生邮箱
     */
    public record StudentRecord(Long stuId,
                                String stuName,
                                int stuAge,
                                String stuGender,
                                String stuEmail) {

        public StudentRecord {
            System.out.println("构造函数");
        }

        public static void main(String[] args) {
            StudentRecord record = new StudentRecord(1L, "张三", 16, "男", "xxx@qq.com");
            System.out.println(record);
        }
    }
