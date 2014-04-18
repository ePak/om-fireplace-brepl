{:dev {:source-paths ["dev" "dev/src/clj" "dev/src/cljs"]
       :dependencies [[ring "1.2.2"]
                      [com.cemerick/piggieback "0.1.3"]
                      [org.clojure/tools.namespace "0.2.4"]]
       :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
       :cljsbuild {:builds {:main {:source-paths ["dev/src/cljs"]}}}}}
