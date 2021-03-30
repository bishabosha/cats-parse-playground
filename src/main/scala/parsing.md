We are at an airport.

Due to recent aviation regulations,
many rules are being enforced about bags and their contents:
- bags must be color-coded
- bags must contain specific quantities of
  other color-coded bags.

Here is a rule list:
```
light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.
```

You have a `shiny gold` bag.

We want to put it in at least one other bag,
so which bag colors are valid as the outermost bag?

We use a parsing library to take the text and
construct a graph like representation:

cats-parse:

`cats.parse.Parser0` (May consume zero input):

Three failure modes:

Success:
- parser consumes zero-or-more characters of input
- successfully extracts a value.
- The input offset will be moved forward by the number of characters consumed.

Epsilon failure:
- parser fails to extract a value
- consumes zero characters of input.
- The input offset will not be changed

Arresting failure:
- parser fails to extract a value
- consumes one-or-more characters of input.
- The input offset will be moved forward by the number of characters consumed
- No parsing beyond this point, unless wrapped with a backtracking operator.

`cats.parse.Parser` (Guaranteed to consume input):

- supports kleene star
  (0 or more repetitions of a pattern)



















Additionally, how many other bags must be
contained within a `shiny gold` bag?

Here is another example rule list:
```
shiny gold bags contain 2 dark red bags.
dark red bags contain 2 dark orange bags.
dark orange bags contain 2 dark yellow bags.
dark yellow bags contain 2 dark green bags.
dark green bags contain 2 dark blue bags.
dark blue bags contain 2 dark violet bags.
dark violet bags contain no other bags.
```
