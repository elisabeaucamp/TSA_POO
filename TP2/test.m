clear variables;
close all;
clc;

x = genbrfil;

nd = 1;
nf = 1001;
NFFT = 2^15;

[gamma1, f, N] = estimateur_simple(x, nd, nf, NFFT);
[Gth,Gbiais,fth]=sptheo(N,'simple','hamming');

figure(1);

plot(f, 10*log10(gamma1),'r'); hold on;
plot(fth, Gth, 'b');
plot(fth, Gbiais, 'g');
xlim([0 0.5]);
ylim([-50 10]);
legend("Estimateur simple experimental","Estimateur simple theorique","Moyenne statistique");
title("Estimateur simple");
xlabel("Frequence reduite");
ylabel("Decibels");

##%% Estimateur moyenné %%
##M = 1000;
##N = 10000;
##[gamma2, f2] = estimateur_moy(x, N, M, NFFT);
##
##figure(2);
## 
##plot(f2, 10*log10(gamma2),'r'); hold on;
##plot(fth, Gth, 'b');
##plot(fth, Gbiais, 'g');
##xlim([0 0.5]);
##ylim([-50 10]);
##
##%% Estimateur de Welch %%
##%fenetre;