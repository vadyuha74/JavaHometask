
public class solutionhorse {
    // Шахматная доска `N × N`
    public static int N = 5;

    // Ниже массивы детализируют все восемь возможных движений коня.
    public static int[] row = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
    public static int[] col = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };

    // Проверяем, являются ли `(x, y)` действительными координатами шахматной доски.
    // Обратите внимание, что конь не может выйти за пределы доски
    private static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }

        return true;
    }

    // Рекурсивная функция для выполнения обхода коня доски
    public static void knightTour(int[][] visited, int x, int y, int pos) {
        System.out.println(x * visited.length + y + 1); // вывод номера квадрата

        visited[x][y] = pos;
        if (pos >= visited.length * visited.length)
            return; // если все квадраты посещены, выход из рекурсии
        

        else {
            for (int k = 0; k < 8; k++) { // проверка всех восьми возможных движений коня
                // получаем новую позицию коня из текущей
                int newX = x + row[k];
                int newY = y + col[k];

                // если новая позиция действительна и еще не посещена
                if (isValid(newX, newY) && visited[newX][newY] == 0) {
                    knightTour(visited, newX, newY, pos + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        
        int[][] visited = new int[N][N];
        int pos = 1;

        // начинаем обход конем с углового квадрата `(0, 0)` позиция 1
        knightTour(visited, 0, 0, pos);
    }
}
