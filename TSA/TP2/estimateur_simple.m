function [gamma1, f, N] = estimateur_simple(x, nd, nf, NFFT)

x_s = x(nd:nf);
N = length(x_s);

delta_f = 1/NFFT;
f = 0:delta_f:1-delta_f;

X = fft(x_s, NFFT);
gamma1 = (abs(X).^2)/N;
end