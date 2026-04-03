package tower;

public class TestSuite {

    private boolean pass = false;
    private int score = 0;
    private int maxScore = 0;

    public TestSuite()
    {
    }

    public void run()
    {
        System.out.println("Starting TestSuite");
        pass = true;
        score = 0;
        maxScore = 0;

        TowerModel tiny = new TowerModel(2);
        expectEqual(tiny.getHeight(), 2, "height should be 1");

        IntegerStack[] towers = tiny.getTowers();
        expectEqual(towers[0].get(0), 2, "tower0 should contain 2");

        tiny.move(0, 2);

        expectEqual(towers[2].get(0), 1, "disk 1 should move to tower2");

        tiny.move(0, 2);

        expectEqual(towers[2].get(1), 0, "disk 2 should not have moved");

        TowerModel hanoi = new TowerModel(3);
        towers = hanoi.getTowers();
        expectEqual(towers[0].get(0), 3, "tower0 should have disk 3 on bottom");
        expectEqual(towers[2].get(0), 0, "tower2 should have zero disks");

        TowerSolver solver = new TowerSolver();
        solver.solve(hanoi);

        expectEqual(towers[0].get(0), 0, "tower0 should have zero disks");
        expectEqual(towers[2].get(0), 3, "tower2 should have disk 3 on bottom");

        if (pass == true)
        {
            System.out.println("--- TEST PASSED! Congrats! Score: " + score + "/" + maxScore + " ---");
        }
        else
        {
            System.out.println("--- TEST FAILED! :( Score: " + score + "/" + maxScore + " ---");
        }
    }

    private void expectEqual(int value, int expected, String note)
    {
        maxScore += 1;
        if (value != expected)
        {
            System.out.println("Value: " + value + " != " + expected + ", " + note);
            pass = false;
        }
        else
        {
            score += 1;
        }
    }
}
