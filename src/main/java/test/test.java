package test;

public class test {
    public static void main(String[] args) {
        TestOne testOne = new TestOne();
        System.err.println("testOne:" + testOne.a);

        TestTwo testTwo = new TestTwo();
        testTwo.changeFeature(testOne);

        System.out.println("testOne1:" + testOne.a);

    }
}
