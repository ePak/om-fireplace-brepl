# om-fireplace-brepl

A minimum [Om](https://github.com/swannodette/om/) project template with browser repl via [fireplace.vim](https://github.com/tpope/vim-fireplace).

## Usage
This is the general instructions, see [Details](#details) for explanations and trouble-shooting.

*Terminal #1:*
```
> lein new om-fireplace-brepl hello-world
> cd hello-world
> lein cljsbuild once
> lein repl
user => (go)
```

*Terminal #2 (optional):*
```
> cd <hello-world-dir>
> lein trampoline cljsbuild auto
```

*Vim (edit &lt;hello-world-dir&gt;/src/cljs/core.cljs):*
```
:Piggieback (brepl-env)
```

*Browser:*
```
http://localhost:3000
```

Evaluate expressions in Vim.

## <a name="details"></a>Details

This template scaffolds an environment for you to follow the [basic tutorial](https://github.com/swannodette/om/wiki/Basic-Tutorial) of [Om](https://github.com/swannodette/om/) using VIM instead of [Light Table](http://www.lighttable.com) assuming you are already using [fireplace.vim](https://github.com/tpope/vim-fireplace).

1.  Create a project using this template:
    ```
    > lein new om-fireplace-brepl hello-world
    > cd hello-world
    ```

2.  Compile cljs files into Javascript:
    ```
    > lein cljsbuild once
    ```
    **-OR-**

    For convenience, you can setup auto-compiling to watch for cljs files changes. In a **separate terminal**:
    ```
    > cd <hello-world-dir>
    > lein trampoline cljsbuild auto
    ```

3.  Start the normal repl (in the original terminal):
    ```
    > lein repl
    ```

4.  In order for the browser to connect to the brepl, files must be served via a web server instead of the file:/// protocol. This template provides some helper functions in the `*user*` namespace to start/stop a web server and reload modified clj files, which based upon a [blog entry](http://thinkrelevance.com/blog/2013/06/04/clojure-workflow-reloaded) by [Stuart Sierra](https://github.com/stuartsierra).

    Now, start the web server from the repl:
    ```
    user=> (go)
    ```

5.  In the browser, go to http://localhost:3000. Open the Javascript console and you should see an error because we have not started our brepl:

    ![failed_connect](https://raw.github.com/ePak/om-fireplace-brepl/screenshots/failed_connect.png)

6.  fireplace.vim provides the `:Piggieback` command and uses [Piggieback](https://github.com/cemerick/piggieback) to connect to the brepl.

    In VIM, open `<hello-world-dir>/src/cljs/core.cljs` and start the brepl via:
    ```
    :Piggieback (brepl-env)
    ```

7.  Go back to the browser and refresh the page. You should not longer have the previous Javascript error.

    ![successfull_connect](https://raw.github.com/ePak/om-fireplace-brepl/screenshots/successful_connect.png)

8.  Now we can try evaluate an expression via the brepl from VIM. In normal mode, type `cqp` to bring up the brepl command prompt (see [fireplace.vim](https://github.com/tpope/vim-fireplace) for other ways to evaluate expressions) and enter:

    ```
    hello-world=> (.log js/console "hello brepl")
    ```

9.  Go back to the browser and you should see this:

    ![hello_brepl](https://raw.github.com/ePak/om-fireplace-brepl/screenshots/hello_brepl.png)

    > ***WARNING***
    >
    > In theory, "hello brepl" should show up in the Javascript console in the browser after a second or two (the first evaluation usually takes longer, evaluating simple expressions afterwards are almost instantaneous).
    >
    > But sometimes VIM might just stuck there and nothing happens in the browser (my Macbook Air does this every time, but not on my Windows 7 box surprisingly). In this case, try refreshing in the browser once or twice.   

10. You are now ready to follow Om's [basic tutorial](https://github.com/swannodette/om/wiki/Basic-Tutorial).

## License

Copyright © 2014 Eric Pak

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

