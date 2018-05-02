package com.grandgroup.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.grandgroup.R;
import com.grandgroup.views.CustomDateDialog;
import com.grandgroup.views.CustomTimeDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IncidentReportsActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.my_toolbar)
    RelativeLayout myToolbar;
    @BindView(R.id.tv_affected)
    TextView tvAffected;
    @BindView(R.id.et_affected)
    EditText etAffected;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.rb_contractor)
    RadioButton rbContractor;
    @BindView(R.id.rb_member)
    RadioButton rbMember;
    @BindView(R.id.rg_type)
    RadioGroup rgType;
    @BindView(R.id.tv_occurence)
    TextView tvOccurence;
    @BindView(R.id.tv_occurence_value)
    TextView tvOccurenceValue;
    @BindView(R.id.tv_ceased)
    TextView tvCeased;
    @BindView(R.id.rb_ceased_yes)
    RadioButton rbCeasedYes;
    @BindView(R.id.rb_ceased_no)
    RadioButton rbCeasedNo;
    @BindView(R.id.rg_ceased)
    RadioGroup rgCeased;
    @BindView(R.id.tv_ceased_time)
    TextView tvCeasedTime;
    @BindView(R.id.tv_ceased_time_value)
    TextView tvCeasedTimeValue;
    @BindView(R.id.tv_report_time)
    TextView tvReportTime;
    @BindView(R.id.tv_report_time_value)
    TextView tvReportTimeValue;
    @BindView(R.id.tv_occurence_date)
    TextView tvOccurenceDate;
    @BindView(R.id.rb_occ_yes)
    RadioButton rbOccYes;
    @BindView(R.id.rb_occ_no)
    RadioButton rbOccNo;
    @BindView(R.id.rg_occurence)
    RadioGroup rgOccurence;
    @BindView(R.id.tv_first_name)
    TextView tvFirstName;
    @BindView(R.id.et_firstname)
    EditText etFirstname;
    @BindView(R.id.tv_surname)
    TextView tvSurname;
    @BindView(R.id.et_surname)
    EditText etSurname;
    @BindView(R.id.tv_gender)
    TextView tvGender;
    @BindView(R.id.rb_male)
    RadioButton rbMale;
    @BindView(R.id.rb_female)
    RadioButton rbFemale;
    @BindView(R.id.rg_gender)
    RadioGroup rgGender;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.et_state)
    EditText etState;
    @BindView(R.id.tv_postcode)
    TextView tvPostcode;
    @BindView(R.id.et_postcode)
    EditText etPostcode;
    @BindView(R.id.tv_home_phone)
    TextView tvHomePhone;
    @BindView(R.id.et_home_phone)
    EditText etHomePhone;
    @BindView(R.id.tv_mobile_no)
    TextView tvMobileNo;
    @BindView(R.id.et_mobile_no)
    EditText etMobileNo;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.et_birthday)
    TextView etBirthday;
    @BindView(R.id.tv_occupation)
    TextView tvOccupation;
    @BindView(R.id.et_occupation)
    TextView etOccupation;
    @BindView(R.id.tv_workplace)
    TextView tvWorkplace;
    @BindView(R.id.et_workplace)
    TextView etWorkplace;
    @BindView(R.id.tv_addres)
    TextView tvAddres;
    @BindView(R.id.et_addres)
    TextView etAddres;
    @BindView(R.id.tv_incident)
    TextView tvIncident;
    @BindView(R.id.et_incident)
    TextView etIncident;
    @BindView(R.id.tv_event_class)
    TextView tvEventClass;
    @BindView(R.id.rb_miss)
    RadioButton rbMiss;
    @BindView(R.id.rb_incident)
    RadioButton rbIncident;
    @BindView(R.id.rb_hazard)
    RadioButton rbHazard;
    @BindView(R.id.rb_contact)
    RadioButton rbContact;
    @BindView(R.id.rb_issue)
    RadioButton rbIssue;
    @BindView(R.id.rg_event_class)
    RadioGroup rgEventClass;
    @BindView(R.id.tv_brief)
    TextView tvBrief;
    @BindView(R.id.et_brief)
    EditText etBrief;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.et_description)
    EditText etDescription;
    @BindView(R.id.tv_action)
    TextView tvAction;
    @BindView(R.id.et_action)
    EditText etAction;
    @BindView(R.id.tv_injury)
    TextView tvInjury;
    @BindView(R.id.et_injury)
    EditText etInjury;
    @BindView(R.id.tv_illness)
    TextView tvIllness;
    @BindView(R.id.et_illness)
    EditText etIllness;
    @BindView(R.id.tv_bodily)
    TextView tvBodily;
    @BindView(R.id.et_bodily)
    EditText etBodily;
    @BindView(R.id.tv_mark)
    TextView tvMark;
    @BindView(R.id.et_mark)
    EditText etMark;
    @BindView(R.id.tv_mechanism)
    TextView tvMechanism;
    @BindView(R.id.et_mechanism)
    EditText etMechanism;
    @BindView(R.id.tv_others)
    TextView tvOthers;
    @BindView(R.id.et_others)
    EditText etOthers;
    @BindView(R.id.tv_observe)
    TextView tvObserve;
    @BindView(R.id.et_observe)
    EditText etObserve;
    @BindView(R.id.tv_third_party)
    TextView tvThirdParty;
    @BindView(R.id.rb_third_yes)
    RadioButton rbThirdYes;
    @BindView(R.id.rb_third_no)
    RadioButton rbThirdNo;
    @BindView(R.id.rg_third_party)
    RadioGroup rgThirdParty;
    @BindView(R.id.tv_third_report)
    TextView tvThirdReport;
    @BindView(R.id.et_third_report)
    EditText etThirdReport;
    @BindView(R.id.tv_prop_damage)
    TextView tvPropDamage;
    @BindView(R.id.rb_damage_yes)
    RadioButton rbDamageYes;
    @BindView(R.id.rb_damage_no)
    RadioButton rbDamageNo;
    @BindView(R.id.rg_prop_damage)
    RadioGroup rgPropDamage;
    @BindView(R.id.tv_damage_adv)
    TextView tvDamageAdv;
    @BindView(R.id.et_damage_adv)
    EditText etDamageAdv;
    @BindView(R.id.tv_damage_veh)
    TextView tvDamageVeh;
    @BindView(R.id.et_damage_veh)
    EditText etDamageVeh;
    @BindView(R.id.tv_attend_affe)
    TextView tvAttendAffe;
    @BindView(R.id.rb_attend_yes)
    RadioButton rbAttendYes;
    @BindView(R.id.rb_attend_no)
    RadioButton rbAttendNo;
    @BindView(R.id.rg_attend_affe)
    RadioGroup rgAttendAffe;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_first_aid)
    TextView tvFirstAid;
    @BindView(R.id.rb_aid_yes)
    RadioButton rbAidYes;
    @BindView(R.id.rb_aid_no)
    RadioButton rbAidNo;
    @BindView(R.id.rg_first_aid)
    RadioGroup rgFirstAid;
    @BindView(R.id.tv_aid_yes_admin)
    TextView tvAidYesAdmin;
    @BindView(R.id.tv_aid_admin)
    TextView tvAidAdmin;
    @BindView(R.id.et_aid_name)
    EditText etAidName;
    @BindView(R.id.tv_signature)
    TextView tvSignature;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.lay_signature)
    ConstraintLayout laySignature;
    @BindView(R.id.tv_injury_det)
    TextView tvInjuryDet;
    @BindView(R.id.et_injury_detail)
    EditText etInjuryDetail;
    @BindView(R.id.tv_med_center)
    TextView tvMedCenter;
    @BindView(R.id.et_med_center)
    EditText etMedCenter;
    @BindView(R.id.tv_date_atten)
    TextView tvDateAtten;
    @BindView(R.id.et_date_atten)
    TextView etDateAtten;
    @BindView(R.id.tv_ambulance)
    TextView tvAmbulance;
    @BindView(R.id.rb_amb_yes)
    RadioButton rbAmbYes;
    @BindView(R.id.rb_amb_no)
    RadioButton rbAmbNo;
    @BindView(R.id.rg_ambulance)
    RadioGroup rgAmbulance;
    @BindView(R.id.tv_amb_req)
    TextView tvAmbReq;
    @BindView(R.id.et_amb_req)
    EditText etAmbReq;
    @BindView(R.id.tv_amb_per)
    TextView tvAmbPer;
    @BindView(R.id.tv_amb_per_name)
    TextView tvAmbPerName;
    @BindView(R.id.et_amb_per_name)
    EditText etAmbPerName;
    @BindView(R.id.tv_amb_per_sign)
    TextView tvAmbPerSign;
    @BindView(R.id.iv_amb_per_sign)
    ImageView ivAmbPerSign;
    @BindView(R.id.lay_amb_per_sign)
    ConstraintLayout layAmbPerSign;
    @BindView(R.id.tv_amb_date)
    TextView tvAmbDate;
    @BindView(R.id.et_amb_date)
    TextView etAmbDate;
    @BindView(R.id.et_complete_note)
    TextView etCompleteNote;
    @BindView(R.id.tv_weather_reas)
    TextView tvWeatherReas;
    @BindView(R.id.rb_weather_yes)
    RadioButton rbWeatherYes;
    @BindView(R.id.rb_weather_no)
    RadioButton rbWeatherNo;
    @BindView(R.id.rg_weather)
    RadioGroup rgWeather;
    @BindView(R.id.tv_weather_cond)
    TextView tvWeatherCond;
    @BindView(R.id.et_weather_cond)
    EditText etWeatherCond;
    @BindView(R.id.tv_drug_affect)
    TextView tvDrugAffect;
    @BindView(R.id.rb_drug_yes)
    RadioButton rbDrugYes;
    @BindView(R.id.rb_drug_no)
    RadioButton rbDrugNo;
    @BindView(R.id.rg_drug_affect)
    RadioGroup rgDrugAffect;
    @BindView(R.id.tv_footwear)
    TextView tvFootwear;
    @BindView(R.id.et_footwear)
    EditText etFootwear;
    @BindView(R.id.tv_eyewear)
    TextView tvEyewear;
    @BindView(R.id.et_eyewear)
    EditText etEyewear;
    @BindView(R.id.tv_carrying)
    TextView tvCarrying;
    @BindView(R.id.et_carrying)
    EditText etCarrying;
    @BindView(R.id.tv_cctv)
    TextView tvCctv;
    @BindView(R.id.rb_cctv_yes)
    RadioButton rbCctvYes;
    @BindView(R.id.rb_cctv_no)
    RadioButton rbCctvNo;
    @BindView(R.id.rg_cctv)
    RadioGroup rgCctv;
    @BindView(R.id.tv_photos)
    TextView tvPhotos;
    @BindView(R.id.rb_photos_yes)
    RadioButton rbPhotosYes;
    @BindView(R.id.rb_photos_no)
    RadioButton rbPhotosNo;
    @BindView(R.id.rg_photos)
    RadioGroup rgPhotos;
    @BindView(R.id.tv_wand_report)
    TextView tvWandReport;
    @BindView(R.id.rb_wand_yes)
    RadioButton rbWandYes;
    @BindView(R.id.rb_wand_no)
    RadioButton rbWandNo;
    @BindView(R.id.rg_wand_report)
    RadioGroup rgWandReport;
    @BindView(R.id.tv_wet_weather)
    TextView tvWetWeather;
    @BindView(R.id.rb_wet_yes)
    RadioButton rbWetYes;
    @BindView(R.id.rb_wet_no)
    RadioButton rbWetNo;
    @BindView(R.id.rg_wet_weather)
    RadioGroup rgWetWeather;
    @BindView(R.id.tv_any_com)
    TextView tvAnyCom;
    @BindView(R.id.et_comment)
    EditText etComment;
    @BindView(R.id.tv_incident_specs)
    TextView tvIncidentSpecs;
    @BindView(R.id.rb_crunches)
    RadioButton rbCrunches;
    @BindView(R.id.rb_stick)
    RadioButton rbStick;
    @BindView(R.id.rb_frame)
    RadioButton rbFrame;
    @BindView(R.id.rb_wheelchair)
    RadioButton rbWheelchair;
    @BindView(R.id.rb_motorised)
    RadioButton rbMotorised;
    @BindView(R.id.rg_incident_specs)
    RadioGroup rgIncidentSpecs;
    @BindView(R.id.tv_ensure)
    TextView tvEnsure;
    @BindView(R.id.tv_notes)
    TextView tvNotes;
    @BindView(R.id.et_notes)
    EditText etNotes;
    @BindView(R.id.lay_screenshot)
    ConstraintLayout layScreenshot;
    private AppCompatActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_reports);
        ButterKnife.bind(this);
        setInitialData();
    }

    private void setInitialData() {
        mContext = IncidentReportsActivity.this;
        ButterKnife.bind(mContext);
        tvTitle.setText("Incident Reports");
    }

    @OnClick({R.id.btn_back, R.id.btn_add, R.id.rg_type, R.id.rg_ceased, R.id.rg_occurence, R.id.rg_gender, R.id.rg_third_party, R.id.rg_prop_damage, R.id.rg_attend_affe, R.id.rg_first_aid, R.id.lay_signature, R.id.lay_amb_per_sign, R.id.rg_cctv, R.id.rg_wand_report, R.id.rg_wet_weather, R.id.rg_incident_specs, R.id.lay_screenshot,
            R.id.tv_occurence_value,R.id.tv_ceased_time_value,R.id.tv_report_time_value})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                mContext.overridePendingTransition(R.anim.slide_right_out, R.anim.slide_right_in);
                break;
            case R.id.btn_add:
                break;
            case R.id.rg_type:
                break;
            case R.id.rg_ceased:
                break;
            case R.id.rg_occurence:
                break;
            case R.id.rg_gender:
                break;
            case R.id.rg_third_party:
                break;
            case R.id.rg_prop_damage:
                break;
            case R.id.rg_attend_affe:
                break;
            case R.id.rg_first_aid:
                break;
            case R.id.lay_signature:
                break;
            case R.id.lay_amb_per_sign:
                break;
            case R.id.rg_cctv:
                break;
            case R.id.rg_wand_report:
                break;
            case R.id.rg_wet_weather:
                break;
            case R.id.rg_incident_specs:
                break;
            case R.id.lay_screenshot:
                break;
            case R.id.tv_occurence_value:
                CustomDateDialog.getInstance().DatePicker(mContext, new CustomDateDialog.DateDialogListener() {
                    @Override
                    public void onOkayClick(int date, int month, int year) {
                        CustomTimeDialog.getInstance().timePicker(mContext, new CustomTimeDialog.TimeDialogListener() {
                            @Override
                            public void onOkayClick(String twentyFourTime, String TwelveHourTime) {

                            }
                        });
                    }
                });
                break;
            case R.id.tv_ceased_time_value:
                CustomDateDialog.getInstance().DatePicker(mContext, new CustomDateDialog.DateDialogListener() {
                    @Override
                    public void onOkayClick(int date, int month, int year) {
                        CustomTimeDialog.getInstance().timePicker(mContext, new CustomTimeDialog.TimeDialogListener() {
                            @Override
                            public void onOkayClick(String twentyFourTime, String TwelveHourTime) {

                            }
                        });
                    }
                });
                break;
            case R.id.tv_report_time_value:
                CustomDateDialog.getInstance().DatePicker(mContext, new CustomDateDialog.DateDialogListener() {
                    @Override
                    public void onOkayClick(int date, int month, int year) {
                        CustomTimeDialog.getInstance().timePicker(mContext, new CustomTimeDialog.TimeDialogListener() {
                            @Override
                            public void onOkayClick(String twentyFourTime, String TwelveHourTime) {

                            }
                        });
                    }
                });
                break;
        }
    }
}
