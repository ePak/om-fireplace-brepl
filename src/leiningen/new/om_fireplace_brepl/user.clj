(ns user
  (:require [clojure.tools.namespace.repl :refer [refresh refresh-all]]
            [ring.adapter.jetty :refer [run-jetty]]
            [{{name}}.app :refer [handler]]
            [cljs.repl.browser]))

(defn brepl-env 
  []
  (cljs.repl.browser/repl-env :port 9000))

(def system nil)

(defn init 
  []
  (alter-var-root #'system 
                  (constantly (run-jetty handler {:port 3000 :join? false}))))


(defn start [] (.start system))

(defn stop [] (.stop system))

(defn go
  []
  (require '[clojure.repl :refer :all])
  (init)
  (start))


(defn reset
  []
  (stop)
  (refresh :after 'user/go))

