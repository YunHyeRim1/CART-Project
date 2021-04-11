import React from 'react';
import { useForm, Controller } from 'react-hook-form';
import { MdEmail } from 'react-icons/md';
import { Input, Button } from 'antd';
import { Logo, FormControl } from 'components/index';
import Wrapper, {
  Title,
  TitleInfo,
  FormWrapper,
  BannerWrapper,
} from 'container/user/Auth.style';

export default function ForgetPassWord() {
  const { control, errors, handleSubmit } = useForm({
    mode: 'onChange',
  });
  const onSubmit = (data) => {
    console.log(data);
  };

  return (
    <Wrapper>
      <FormWrapper>
        <Title>Welcome Back</Title>
        <TitleInfo>가입할 때 적으신 이메일을 입력해주세요
        </TitleInfo>
        <form onSubmit={handleSubmit(onSubmit)}>
          <FormControl
            label="Email"
            htmlFor="email"
            error={
              errors.email && (
                <>
                  {errors.email?.type === 'required' && (
                    <span>빈 칸을 작성해주세요</span>
                  )}
                  {errors.email?.type === 'pattern' && (
                    <span>이메일 형식에 맞게 작성해주세요</span>
                  )}
                </>
              )
            }
          >
            <Controller
              as={<Input />}
              type="email"
              id="email"
              name="email"
              defaultValue=""
              control={control}
              rules={{
                required: true,
                pattern: /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/,
              }}
            />
          </FormControl>
          <Button
            className="signin-btn"
            type="primary"
            htmlType="submit"
            size="large"
            style={{ width: '100%' }}
          >
            <MdEmail />
            Send email
          </Button>
        </form>
      </FormWrapper>
      <BannerWrapper>
        <img src="/images/signup_page_bg.jpg" alt="Auth page banner" />
      </BannerWrapper>
    </Wrapper>
  );
}