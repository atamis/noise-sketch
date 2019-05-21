# noise-sketch

A Quil sketch designed to show OpenSimplex noise.

## Installation

This requires the [`cmaher/noise`](https://github.com/cmaher/noise) library,
which is not published to maven. To use the library, clone it, and run
`lein install` to install the `jar` and `pom` to your local maven repository.

## Usage

LightTable - open `core.clj` and press `Ctrl+Shift+Enter` to evaluate the file.

Emacs - run cider, open `core.clj` and press `C-c C-k` to evaluate the file.

REPL - run `(require 'noise-sketch.core)`.

Run - `(noise-sketch.core/-main)`

Reload - `(require 'noise-sketch.dynamic' :reload-all)`

## License

Copyright © 2016 Andrew Amis

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
