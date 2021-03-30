import cats.parse.{Parser => P, Numbers}

val input1 =
  "shiny gold bags contain 2 dark red bags.\n" +
  "dark red bags contain 2 dark orange bags.\n" +
  "dark orange bags contain 2 dark yellow bags.\n" +
  "dark yellow bags contain 2 dark green bags.\n" +
  "dark green bags contain 2 dark blue bags.\n" +
  "dark blue bags contain 2 dark violet bags.\n" +
  "dark violet bags contain no other bags."

val input2 =
  "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
  "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
  "bright white bags contain 1 shiny gold bag.\n" +
  "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
  "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
  "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
  "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
  "faded blue bags contain no other bags.\n" +
  "dotted black bags contain no other bags."

case class Material(adj: String, color: String)
case class Bag(material: Material, sub: List[(Int, Material)])

def sp = P.char(' ')
def nl = P.char('\n')

def word = P.charsWhile(('a' to 'z').contains)

def nat = Numbers.nonZeroDigit ~ Numbers.digits0 map ((d, ds) => (d +: ds).toInt)

def one = P.char('1') as 1

def material = (word <* sp) ~ word map Material.apply

def noBags = P.string("no other bags") as List.empty

def oneBag = (one <* sp) ~ material <* P.string(" bag")

def multiBag = (nat <* sp) ~ material <* P.string(" bags")

def natBag = P.oneOf(List(oneBag, multiBag))

def natBags = (natBag repSep P.string(", "))

def nestedBags = P.oneOf(List(noBags, natBags.map(_.toList))) <* P.char('.')

def bag = (material <* P.string(" bags contain ")) ~ nestedBags map Bag.apply

def bags = (bag repSep nl) <* P.end

val Right(bags1) = bags.parse(input1).map(_(1))
val Right(bags2) = bags.parse(input2).map(_(1))
