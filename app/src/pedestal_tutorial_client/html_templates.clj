(ns pedestal-tutorial-client.html-templates
  (:use [io.pedestal.app.templates :only [tfn dtfn tnodes]]))

(defmacro pedestal-tutorial-client-templates
  []
  {:pedestal-tutorial-client-page (dtfn (tnodes "pedestal-tutorial-client.html" "hello") #{:id})})
