package ru.spsuace.projects.pass_fail;

class SingletonTest {

    public static void main(String[] args) {

        Singleton firstInstance = Singleton.getInstance();
        System.out.println(firstInstance.getClass());
        Singleton secondInstance = Singleton.getInstance();
        System.out.println(secondInstance == firstInstance);

    }

}