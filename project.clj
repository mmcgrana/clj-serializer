(defproject clj-serializer "0.1.0-SNAPSHOT"
  :description "Fast binary serialization and deserialization for Clojure data structures."
  :url "http://github.com/mmcgrana/clj-serializer"
  :source-path "src/clj"
  :java-source-path "src/jvm"
  :javac-fork "true"
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.1.0"]]
  :dev-dependencies [[clj-json "0.1.0-SNAPSHOT"]
                     [lein-clojars "0.5.0-SNAPSHOT"]
                     [lein-javac "0.0.2-SNAPSHOT"]])
