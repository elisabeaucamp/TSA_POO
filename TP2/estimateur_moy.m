function [gamma2, f] = estimateur_moy(x, N, M, NFFT)
x_s = x(1:N);
[gamma2, f] = pwelch(x_s, rectwin(M), 0, NFFT, 1, 'twosided');

end