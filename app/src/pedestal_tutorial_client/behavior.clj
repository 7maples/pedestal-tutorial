(ns ^:shared pedestal-tutorial-client.behavior
    (:require [clojure.string :as string]
              [io.pedestal.app.messages :as msg]
              [io.pedestal.app :as app]))

(defn init-main [_]
  [[:transform-enable [:main :my-counter] :inc [{msg/topic [:my-counter]}]]])

(defn inc-transform [old-value _]
  ((fnil inc 0) old-value))

(def example-app
  {:version 2
   :transform [[:inc [:my-counter] inc-transform]]
   :emit [{:init init-main}
          [#{[:*]} (app/default-emitter [:main])]]})

(defn data-model [app]
  (-> app :state deref :data-model))




