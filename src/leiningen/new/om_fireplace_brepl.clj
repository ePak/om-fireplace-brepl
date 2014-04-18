(ns leiningen.new.om-fireplace-brepl
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "om-fireplace-brepl"))

(defn om-fireplace-brepl
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' om-fireplace-brepl project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["profiles.clj" (render "profiles.clj" data)]
             ["src/clj/{{sanitized}}/app.clj" (render "app.clj" data)]
             ["src/cljs/core.cljs" (render "core.cljs" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ["dev/user.clj" (render "user.clj" data)]
             ["dev/src/cljs/connect.cljs" (render "connect.cljs" data)])))
