package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solve(model.height(), 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    public void solve(int n, int source, int destination, int auxiliary)
    {
        if (n <= 0)
        {
            return;
        }

        // Move n-1 disks from source to auxiliary
        solve(n - 1, source, auxiliary, destination);

        // Move single disk from source to destination
        model.move(source, destination);

        // Move n-1 disks from auxiliary to destination
        solve(n - 1, auxiliary, destination, source);
    }

}
