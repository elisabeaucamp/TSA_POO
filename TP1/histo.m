function [ddp, c, h, xout] = histo(N,m,sigma, M)

if nargin==3
  delta_x=3.49*std(N)^2*length(N)^(-1/3);
  c1=min(N)+delta_x/2;
  cx=max(N)-delta_x/2;
  c=c1:delta_x:cx;
  [h,xout]=hist(N,length(c));
  h=h/(length(N)*delta_x);
  ddp = (1/(sigma*sqrt(2*pi)))*exp((-(xout-m).^2)/(2*sigma^2));

else nargin == 4
  delta_x=(max(N)-min(N))/M;
  [h,xout]=hist(N,M);
  h=h/(length(N)*delta_x);
  ddp = (1/(sigma*sqrt(2*pi)))*exp((-(xout-m).^2)/(2*sigma^2));

end

