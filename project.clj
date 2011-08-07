(defproject clj-serializer "0.1.2"
  :description "Fast binary serialization and deserialization for Clojure data structures."
  :url "http://github.com/mmcgrana/clj-serializer"
  :source-path "src/clj"
  :java-source-path "src/jvm"
  :javac-fork "true"
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.1.0"]]
  :dev-dependencies [[clj-json "0.2.0"]
                     [lein-clojars "0.5.0"]
                     [org.clojars.mmcgrana/lein-javac "0.1.0"]])
