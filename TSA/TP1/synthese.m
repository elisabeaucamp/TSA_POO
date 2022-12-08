function [x1, x2, x3, Az, Bz] = synthese(N, B, m3, sigma3)

m = 8;
Fs = 1000;

[Bz, Az] = butter(m, (2*B)/Fs);

x1 = randn(1, N);
x2 = filter(Bz, Az, x1);
m2 = mean(x2);
x3 = ((x2-m2)./std(x2)).*sigma3+m3;
