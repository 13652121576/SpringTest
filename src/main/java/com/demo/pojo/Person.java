package         com.demo.pojo;

import         org.springframework.context.annotation.Bean;

/**
         *         @ProjectName:         springmvc
         *         @Package:         com.demo.pojo
         *         @ClassName:         Person
         *         @Author:         Administrator
         *         @Description:         ${description}
         *         @Date:         2019/9/3         17:49
         *         @Version:         1.0
         */
public         class         Person         {
                                    private         String         name;
                                    private         int         age;

                                    public         String         getName()         {
                                                                        return         name;
                                    }

                                    public         void         setName(String         name)         {
                                                                        this.name         =         name;
                                    }

                                    public         int         getAge()         {
                                                                        return         age;
                                    }

                                    public         void         setAge(int         age)         {
                                                                        this.age         =         age;
                                    }
}
