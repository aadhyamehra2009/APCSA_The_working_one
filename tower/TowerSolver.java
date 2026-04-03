package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solve(model.height(), 0, 2, 1);
    }

    public void solve(int n, int source, int destination, int auxiliary)
    {
        if (n <= 0)
        {
            return;
        }

        solve(n - 1, source, auxiliary, destination);

        model.move(source, destination);

        solve(n - 1, auxiliary, destination, source);
    }

}
