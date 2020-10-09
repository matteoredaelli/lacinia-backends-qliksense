(ns matteoredaelli.lacinia-backends-qliksense.schema
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [com.walmartlabs.lacinia.schema :as schema]
    [com.walmartlabs.lacinia.util :as util]
    [matteoredaelli.lacinia-backends-qliksense.backend :as backend]))

(defn schema
  []
  (-> (io/resource "schema.edn")
      slurp
      edn/read-string
      (util/attach-resolvers {:resolve-query-qliksense-streams backend/resolve-query-qliksense-streams
                              })
      schema/compile))
