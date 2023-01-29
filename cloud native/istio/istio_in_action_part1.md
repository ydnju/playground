# Chapter 1 Introduction

## Istio as a whole

Solves cross-cutting concerns like resiliency, security and observability for microservices, with distributed data plane and a central control plane.

## 1.1 Challenges: Why whe should use Istio

The cloud infrastructure is not stable, we should make service interactions resilient.

## 1.2
Previously we solve these problems with application libraries, restrictions:

* Language-agnostic, you have restrictions on which language/framework to use

## 1.3

So we push the concerns to infrastructure, we need a layer 7 proxy which understands service requests.
Envoy is a good choice

## 1.4 what is a service mesh

Data Plane + Control Plane:

* Service Resilience
* Observability Signal
* Traffic Control capabilities
* Security
* Policy Enforcement

## 1.4 Drawback

Another hop: performance concerns

Difficulty to debug envoy

Complex management in huge systems

# Chapter 2 First step with Istio