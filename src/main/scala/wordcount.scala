object wordcount extends App {
  val sentence = "A horse is a horse, of course, of course, And no one can talk to a horse of course, That is, of course, unless the horse is the famous Mr. Ed."

  def wordCount(): Unit = {
    // Basic word count function
    var y = 0

    val sent_split = sentence.replace(",", "").toLowerCase().split(" ")
    for (_ <- sent_split) {
      y += 1
    }
    println(sentence)
    println("Total word count: " + y)
  }
/*
  def wordOccFile(): Unit = {
    // Counting occurrence of each word in a text file
    val cxn = new sparkLocal
    val session = cxn.spkSession
    val sc = session.sparkContext

    var sent_split = sc.textFile("words.txt")
      .flatMap(line => line.replace(",", "")
        .split(" ")).map(word => (word, 1))

    var reducedCount = sent_split.reduceByKey(_ + _)

    println(reducedCount.collect.mkString("Array(", ", ", ")"))

  } */

  def wordOccInput(wordlist: List[String]): Map[String, Int] = {
    // Count occurrence of words in a string, output as HashMap
    val map = scala.collection.mutable.HashMap.empty[String, Int]
    for (word <- wordlist) {
      val n = map.getOrElse(word, 0)
      map += (word -> (n + 1))
    }
    map.toMap
  }

  def testLoop(): Unit = {
    println("The value of w is: ")

    for(w <- 0 to 10) {
      println(w);
    }
  }

//  testLoop()
//  wordCount()
//  wordOccFile()

  val sent_split = sentence.replace(",", "").toLowerCase().split(" ").toList

  println(wordOccInput(sent_split))

}
