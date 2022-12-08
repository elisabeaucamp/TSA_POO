function [gamma3, f] = estimateur_welch(x, N, Nom_fenetre, M, NOVERLAP, NFFT)
x_s = x(1:N);
[gamma3, f] = pwelch(x_s, rectwin(M), NOVERLAP, NFFT, 1, Nom_fenetre);

end 