(ns {{name}}.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {:text "Hello World!"}))

(om/root
  (fn [app owner]
    (dom/h2 nil (:text app)))
  app-state
  {:target (. js/document (getElementById "app"))})
