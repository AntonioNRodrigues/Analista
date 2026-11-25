# Analista

A plain Java 8 command-line tool that analyses a text file and reports how often a chosen letter occurs in each word. No external libraries are used.

## Requirements

- Java 25 runtime (`java` on `PATH`).

## Run the smoke test

```bash
java src/Test.java doc.txt src/Analista.java
```

This counts occurrences of `e`, `m` and `x` in `doc.txt`, then writes `output.txt` with the words starting with `e`.

## Run the interactive CLI

```bash
java src/RunAnalista.java src/Analista.java
```

The program asks for a text file name. You can enter either `doc` or `doc.txt`.

Commands:

| Command | Description |
| --- | --- |
| `letter e` | Write `e.out` with counts of words containing `e` 0, 1, 2, 3, 4 or 5+ times |
| `words e output.txt` | Write all words starting with `e` and their frequencies |
| `quit` | Exit |

Matching is case-insensitive, so `letter E` behaves the same as `letter e`.

## Notes

- `src/secondWay/` is the original experimental variant and is kept for reference.
- The sample text `doc.txt` is left unchanged so the original exercise data is preserved.

## License

MIT — see `LICENSE`.
