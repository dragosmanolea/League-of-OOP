package main;

import java.util.ArrayList;
import java.util.List;
import fileio.FileSystem;
public final class GameInputLoader {
	private final String mInputPath;
	private final String mOutputPath;

	GameInputLoader(final String inputPath, final String outputPath) {
		mInputPath = inputPath;
		mOutputPath = outputPath;
	}

	public GameInput load() {
		List<List<String>> lands = new ArrayList<>();
		List<List<String>> positions = new ArrayList<>();
		List<List<String>> moves = new ArrayList<>();
		int n = 0;
		int m = 0;
		int p = 0;
		int r = 0;

		try {
			FileSystem fs = new FileSystem(mInputPath, mOutputPath);

			n = fs.nextInt();
			m = fs.nextInt();

			for (int i = 0; i < n; ++i) {
				lands.add(new ArrayList<>());
				lands.get(i).add(fs.nextWord());
			}

			p = fs.nextInt();

			for (int i = 0; i < p; ++i) {
				positions.add(new ArrayList<>());
				for (int j = 0; j < 3; ++j) {
					positions.get(i).add(fs.nextWord());
				}
			}

			r = fs.nextInt();

			for (int i = 0; i < r; ++i) {
				moves.add(new ArrayList<>());
				moves.get(i).add(fs.nextWord());
			}

			fs.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return new GameInput(n, m, p, r, lands, positions, moves);
	}
}
