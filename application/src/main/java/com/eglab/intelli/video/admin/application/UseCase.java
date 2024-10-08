package com.eglab.intelli.video.admin.application;

public abstract class UseCase<IN, OUT>{

    public abstract OUT execute(IN aIn);
}
