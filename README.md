# Jury Relationship
![Java](https://img.shields.io/badge/Language-Java-orange.svg)

## Project Details
SimpleSocial is a new, exciting, messaging service like nothing you've seen before!
SimpleSocial is a micro-blogging service that allows users to post short messages of 150 characters or less.  All messages are public but a user can follow any other user and get their SimpleSocial included in their home pages.  Each user has a page that lists only their own SimpleSocial, there is also a page that lists mentions of a user (@ + username).

## Project Details and Problem
In the island nation of V most legal disputes are decided by a jury. There are two basic rules that must be strictly followed.
1. No juror should have any relation with the plaintiff or the defendant.
2. There should be no 'relationship' between two potential jurors.

Judge K had her own interpretation of the term 'relationship'. She considered there is a relationship between A and D even if there is no direct relation between them but an indirect one mediated by other potential jurors. For example, if jurors A and B are friends, B knows C and D is a cousin of C then A and D are related.Call this concept of relationship a μ-relation. The judge also demanded as large a pool of potential jurors as possible from the initial random sample of eligible candidates. The final 12 jurors were selected from this pool jointly by both parties in the dispute. Assume that the first criterion is satisfied by some initial processing. So the problem is, given a set of candidates and all direct relationships among them find a maximal set of potential jurors such that no two of them are 'μ-related'. We will call this problem JP1 (juror problem 1). In the beginning, when the judge took up her position a team was set up to come up with the largest possible pool manually. This was time consuming and prone to errors. So she decided to hire computer scientists to automate the process. 


## Update-log
- It was found that sometimes the pool of potential jurors satisfying the judge's rather stringent criteria was too small. Assume that the minimum size of an acceptable pool is 24 . In case this number is not reached Judge K relented to relax the relationship criteria to 2-level direct relation. That is, A and C are considered related if either A is directly related to C or A is directly related to B and B is directly related to C. We will call this a 2-relationship. So now the problem is finding a maximal set of potential jurors without 2-relationship between any pair. We will call it JP2 (juror problem 2).

## Author
#### M TanVir Hossain

Software Engineer

Sydney, Australia

Email: hossain.tanvir.m@gmail.com

Originally this project was done by me in May, 2017. 
