clear variables;
close all;
clc;

n = 10000;
N = randn(1, n);
M = 20;
[ddp, ci] = histo(N);