package tower;

public class Main {

    public static void main(String[] args) {

        solveExample();

        TestSuite test = new TestSuite();
        test.run();

    }

    private static void solveExample() {
        TowerModel model = new TowerModel(3);
        TowerSolver solver = new TowerSolver();
        solver.solve(model);
    }
}
