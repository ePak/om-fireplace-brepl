(ns {{name}}.app
  (:require [compojure.core :refer [routes]]
            [compojure.route :as route]))

(defn wrap-dir-index [handler]
  (fn [req]
    (handler (update-in req [:uri] #(if (= "/" %) "/index.html" %)))))

(def handler (-> (routes (route/resources "/"))
                     (wrap-dir-index)))
