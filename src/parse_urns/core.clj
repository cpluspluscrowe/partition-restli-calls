(ns parse-urns.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn has-urn? [urn]
  (str/includes? urn "urn%3A"))

(defn format-urns [urn-string]
  (format "%s", urn-string))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def input (slurp "input.txt"))
(def urns
  (str/split input #",|\(|\)"))
  (def sponsored-campaigns (partition 5 (filter has-urn? urns)))
  (def join-groups  (map (partial str/join ",") sponsored-campaigns))
  (def to-call (map format-urns join-groups))
  (def to-string (str/join "\n\n" to-call))
  (spit "output.txt" to-string))

