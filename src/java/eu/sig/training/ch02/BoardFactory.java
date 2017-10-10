package eu.sig.training.ch02;

public class BoardFactory {
    public Board createBoard(Square[][] grid) {
        return new BoardCreator(grid).create();
    }
}

class BoardCreator {
	private Square[][] grid;
	private Board board;
	private int width;
	private int height;
	private int xVar = 0;
	private int yVar = 0;
	
	BoardCreator(Square[][] grid) {
		assert grid != null;
		this.grid = grid;
		this.board = new Board(grid);
		this.width = board.getWidth();
		this.height = board.getHeight();
	}
	
	Board create() {
		for (int x = xVar; x < width; x++) {
            for (int y = yVar; y < height; y++) {
                Square square = grid[x][y];
                for (Direction dir : Direction.values()) {
                    setLink(square, dir, x, y);
                }
            }
        }
		return this.board;
	}
	
	private void setLink(Square square, Direction dir, int x, int y) {
		int dirX = (width + x + dir.getDeltaX()) % width;
        int dirY = (height + y + dir.getDeltaY()) % height;
        Square neighbour = grid[dirX][dirY];
        square.link(neighbour, dir);
	}
}

class Board {
    public Board(Square[][] grid) {}

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }
}

class Square {
    public void link(Square neighbour, Direction dir) {}
}

class Direction {

    public static Direction[] values() {
        return null;
    }

    public int getDeltaY() {
        return 0;
    }

    public int getDeltaX() {
        return 0;
    }
}